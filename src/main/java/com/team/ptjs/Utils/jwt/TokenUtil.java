//package com.team.ptjs.Utils.jwt;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.team.ptjs.Api.entity.User;
//
//
//import java.util.Date;
//
//
//public class TokenUtil {
//    private static final long EXPIRE_TIME= 24*60*60*1000;   //十小时
//    private static final String TOKEN_SECRET="123456";  //密钥盐
//    /**
//     * 签名生成
//     * @param user
//     * @return
//     */
//    public static String sign(User user){
//        String token = null;
//        try {
//            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
//            token = JWT.create()
//                    .withIssuer("auth0")
//                    .withClaim("Username", user.getUsername())
////                    .withAudience(staff.getUsername())
//                    .withClaim("Password",user.getPassword())
//                    .withExpiresAt(expiresAt)
//                    // 使用了HMAC256加密算法。
//                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return token;
//    }
//    /**
//     * 签名验证
//     * @param token
//     * @return
//     */
//    public static boolean verify(String token){
//        try {
//            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
//            DecodedJWT jwt = verifier.verify(token);
//            System.out.println("认证通过：");
//            System.out.println("Username: " + jwt.getClaim("Username").asString());
//            System.out.println("过期时间：      " + jwt.getExpiresAt());
//            return true;
//        } catch (Exception e){
//            return false;
//        }
//    }
//}
