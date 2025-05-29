package com.example.testheader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class HeaderController {

    @GetMapping("/user")
    public String test(HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        String rawXff = request.getHeader("X-Forwarded-For");
        String xForwardedProto = request.getHeader("x-forwarded-proto");
        String host = request.getHeader("host");

        System.out.println("Client IP (resolved by Tomcat): " + clientIp);
        System.out.println("Raw X-Forwarded-For: " + rawXff);
        System.out.println("x-forwarded-proto: " + xForwardedProto);
        System.out.println("host: " + host);

        return "Client IP: " + clientIp + "\n" +
               "Raw X-Forwarded-For: " + rawXff + "\n" +
               "x-forwarded-proto: " + xForwardedProto + "\n" +
               "host: " + host;
    }

    @GetMapping("/employee")
    public ResponseEntity<Map<String, String>> getAllHeaders(@RequestHeader Map<String, String> headers) {
        System.out.println("\n=== Request Headers Dump ===");
        headers.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("=== End ===");
        return ResponseEntity.ok(headers);
    }
}
