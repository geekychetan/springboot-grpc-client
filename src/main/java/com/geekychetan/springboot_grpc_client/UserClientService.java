package com.geekychetan.springboot_grpc_client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserClientService {

	@Autowired
	UserServiceGrpc.UserServiceBlockingStub stub;

	public void getUser() {
		UserRequest request = UserRequest.newBuilder().setId(122).build();
		UserResponse userDetails = stub.getUserDetails(request);
		System.out.println("User Details: " + userDetails);
	}

}
