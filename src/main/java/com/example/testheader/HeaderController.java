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
        String xff = request.getHeader("x-forwarded-for");
        String remoteAddr = request.getRemoteAddr();

        System.out.println("🧾 x-forwarded-for: " + xff);
        System.out.println("📡 remoteAddr: " + remoteAddr);

        return "x-forwarded-for: " + xff + "\nremoteAddr: " + remoteAddr;
    }
    @GetMapping("/getheader")
    public ResponseEntity<Map<String, String>> getAllHeaders(@RequestHeader Map<String, String> headers) {
        return ResponseEntity.ok(headers);
    }
}
