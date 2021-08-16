import { Stack, StackProps, Construct } from '@aws-cdk/core';
import { Repository } from '@aws-cdk/aws-ecr';
import { Vpc } from '@aws-cdk/aws-ec2';
import { Cluster, ContainerImage, FargateService, FargateTaskDefinition } from '@aws-cdk/aws-ecs';
import { Effect, ManagedPolicy, PolicyStatement, Role, ServicePrincipal } from '@aws-cdk/aws-iam'

const repoName = 'coding-test-repository';

export class CdkCodingTestStack extends Stack {
  constructor(scope: Construct, id: string, props?: StackProps) {
    super(scope, id, props);

    const ecrRepo = new Repository(this, repoName, {
      repositoryName: repoName
    });

    const vpc = new Vpc(this, 'coding-test-vpc', { maxAzs: 2 });

    const cluster = new Cluster(this, 'coding-test-cluster', {
      clusterName: 'coding-test-cluster',
      vpc
    });

    const executionRole = new Role(this, 'coding-test-execution-role', {
      assumedBy: new ServicePrincipal('ecs-tasks.amazonaws.com'),
      roleName: 'coding-test-execution-role'
    });

    executionRole.addToPolicy(new PolicyStatement({
      effect: Effect.ALLOW,
      resources: ['*'],
      actions: [
        'ecr:GetAuthorizationToken',
        'ecr:BatchCheckLayerAvailability',
        'ecr:GetDownloadUrlForLayer',
        'ecr:BatchGetImage',
        'logs:CreateLogStream',
        'logs:PutLogEvents'
      ]
    }));

    const taskDefinition = new FargateTaskDefinition(this, 'coding-test-task-definition', {
      executionRole,
      family: 'coding-test-task-definition'
    });

    const container = taskDefinition.addContainer('coding-test', {
      image: ContainerImage.fromRegistry('amazon/amazon-ecs-sample')
    });

    const service = new FargateService(this, 'coding-test-fargate-service', {
      cluster,
      taskDefinition,
      serviceName: 'coding-test-fargate-service',
      assignPublicIp: true
    });

    service.taskDefinition.executionRole?.addManagedPolicy(ManagedPolicy.fromAwsManagedPolicyName('AmazonEC2ContainerRegistryPowerUser'));

  }
}
