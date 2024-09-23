package dev.elfa.auth.security;

import lombok.Builder;

@Builder
public record MongoUser(String id, String username, String password) {
}
