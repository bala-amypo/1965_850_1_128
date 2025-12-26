// public class JwtUtil {

//     private final String secret;
//     private final long validityInMs;

//     public JwtUtil(String secret, long validityInMs) {
//         this.secret = secret;
//         this.validityInMs = validityInMs;
//     }

//     public String generateToken(String username) {
//         return Jwts.builder()
//                 .setSubject(username)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + validityInMs))
//                 .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
//                 .compact();
//     }
// }
