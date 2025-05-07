package com.example.demo.security;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public record GitHubEmailFetcher(RestClient restClient) {
    private static final String EMAILS_URL = "https://api.github.com/user/emails";
    private static final String BEARER_PREFIX = "Bearer ";

    public String fetchPrimaryEmailAddress(String token) {

        List<GitHubEmailVm> emailVmList = restClient
                .get()
                .uri(EMAILS_URL)
                .header(HttpHeaders.AUTHORIZATION, BEARER_PREFIX + token)
                .header(HttpHeaders.ACCEPT, "application/vnd.github+json")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });

        if (emailVmList == null || emailVmList.isEmpty()) {
            return null;
        }

        return emailVmList.stream()
                .filter(GitHubEmailVm::primary)
                .findFirst()
                .map(GitHubEmailVm::email)
                .orElse(null);
    }

    private record GitHubEmailVm(String email, Boolean primary) {
    }
}
