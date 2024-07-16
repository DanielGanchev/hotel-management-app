package net.dodo.hotel.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JWTUtils {

  private static final long EXPIRATION_TIME = 1000 * 60  * 24 * 7;

  private final SecretKey secretKey;

  public JWTUtils() {
    String secret = "hncTnDpK4h1SPBMkzp4KcJwIVkJaiZmZPDh7lBmLxwc=";
    byte[] secretBytes = Base64.getDecoder().decode(secret.getBytes(StandardCharsets.UTF_8));
    this.secretKey = new SecretKeySpec(secretBytes, "HmacSHA256");
  }

  public String generateToken(UserDetails userDetails){
    return Jwts.builder()
        .subject(userDetails.getUsername())
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(secretKey)
        .compact();
  }

  public String extractUsername(String token){
    return extractClaims(token,Claims::getSubject);

  }

  private <T> T extractClaims(String token, Function<Claims, T> claimsResolver){
   return claimsResolver.apply(Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload());
  }

  public boolean isValidToken (String token, UserDetails userDetails){
   final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }

  private boolean isTokenExpired(String token) {
    return extractClaims(token, Claims::getExpiration).before(new Date());
  }

}
