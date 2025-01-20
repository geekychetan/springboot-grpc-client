package com.geekychetan.springboot_grpc_client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.GrpcChannelFactory;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Configuration
public class GrpcClientConfig {

	@Bean
	UserServiceGrpc.UserServiceBlockingStub stub(GrpcChannelFactory channels) {
		System.out.println("Injected the bean using available channels: " + channels);
		// Replace "0.0.0.0:8090" with your actual gRPC server address if needed.
		return UserServiceGrpc.newBlockingStub(channels.createChannel("0.0.0.0:8090"));
	}

	// If GrpcChannelFactory is unavailable, fallback to a simple channel:
	@Bean
	ManagedChannel managedChannel() {
		System.out.println("GrpcChannelFactory is unavailable, fallback to a simple channel");
		return ManagedChannelBuilder.forAddress("0.0.0.0", 8090).usePlaintext().build();
	}

}
