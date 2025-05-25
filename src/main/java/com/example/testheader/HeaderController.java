package com.example.testheader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class HeaderController {

    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        // 1️⃣ Get raw x-forwarded-for header (if available)
        String xff = request.getHeader("x-forwarded-for");

        // 2️⃣ Get remoteAddr (client IP resolved by Spring/Tomcat)
        String remoteAddr = request.getRemoteAddr();

        // 3️⃣ Optional: Get other headers if needed
        String xForwardedProto = request.getHeader("x-forwarded-proto");
        String host = request.getHeader("host");

        System.out.println("🧾 x-forwarded-for: " + xff);
        System.out.println("📡 remoteAddr (Spring/Tomcat resolved): " + remoteAddr);
        System.out.println("🌐 x-forwarded-proto: " + xForwardedProto);
        System.out.println("🌍 host: " + host);

        return "x-forwarded-for: " + xff + "\n" +
               "remoteAddr: " + remoteAddr + "\n" +
               "x-forwarded-proto: " + xForwardedProto + "\n" +
               "host: " + host;
    }

    @GetMapping("/getheaders")
    public ResponseEntity<Map<String, String>> getAllHeaders(@RequestHeader Map<String, String> headers) {
        System.out.println("=== Request Headers Dump ===");
        headers.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("=== End ===");
        return ResponseEntity.ok(headers);
    }
}
