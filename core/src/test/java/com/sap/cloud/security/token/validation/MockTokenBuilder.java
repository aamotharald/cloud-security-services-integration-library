package com.sap.cloud.security.token.validation;

import com.sap.cloud.security.token.Token;
import com.sap.cloud.security.token.TokenClaims;
import org.mockito.Mockito;

import java.time.Instant;
import java.util.Arrays;

import static org.mockito.Mockito.when;

public class MockTokenBuilder {

	private final Token token = Mockito.mock(Token.class);

	public MockTokenBuilder withExpiration(Instant expirationDate) {
		when(token.getExpiration()).thenReturn(expirationDate);
		return this;
	}

	public MockTokenBuilder withNotBefore(Instant notBeforeDate) {
		when(token.getNotBefore()).thenReturn(notBeforeDate);
		return this;
	}

	public MockTokenBuilder withClientId(String clientId) {
		when(token.getClaimAsString(TokenClaims.XSUAA.CLIENT_ID)).thenReturn(clientId);
		return this;
	}

	public MockTokenBuilder withScopes(String... scopes) {
		when(token.getClaimAsStringList(TokenClaims.XSUAA.SCOPES)).thenReturn(Arrays.asList(scopes));
		return this;
	}

	public Token build() {
		return token;
	}
}
