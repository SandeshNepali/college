// command for running xaamp in ubuntu mate
// sudo /opt/lampp/lampp start
// cd /opt/lampp
// sudo ./manager-linux-x64.run

package com.assignment.college;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollegeApplication {
	public static void main(String[] args) {
		SpringApplication.run(CollegeApplication.class, args);
	}

}
