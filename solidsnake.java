// ⁙ PRIVATE LICENSE owned by WWW.X-RAY.WORLD
// © COPYRIGHT by X-Ray World Corporation
//        ▇    ▇
//           ▇
//        ▇    ▇
// xrayworld007@gmail.com
// https://www.x-ray.world/
public class Main{
    public static String s0( int r, int g, int b ){ return String.format("\033[48;2;%d;%d;%dm",r,g,b); }
    public static String s1( int r, int g, int b ){ return String.format("\033[38;2;%d;%d;%dm",r,g,b); }
    public static final String s9 = "\033[0m";
    public static void p(String text){ System.out.println(text); }
    public static final String s01logo= s0(102,204,153);
    public static final String s02logo= s0(51,153,102);
    public static final String s011logo= s0(255,102,102);
    public static final String s022logo= s0(204,51,51);
    public static final String s11logo= s1(102,204,153);
    public static final String s12logo= s1(51,153,102);
    public static void main(String[] args){
        p(s1(204,255,255)+"▍▔▔▔  ▍▔▔▍  ▍    ▍  ▍▔▘▖ "+s9);
        p(s1(153,255,204)+"▔▔▔▍  ▍  ▍  ▍    ▍  ▍ ▖▘ "+s9);
        p(s1(102,204,153)+"▔▔▔   ▔▔▔   ▔▔▔     ▔▔   "+s9);
        p(s1(255,204,204)+"▍▔▔▔  ▍▖ ▍  ▍▔▔▍  ▍ ▖▘  ▍▔▔  "+s9);
        p(s1(255,153,153)+"▔▔▔▍  ▍ ▘▍  ▍  ▍  ▍▔▘▖  ▍▔▔  "+s9);
        p(s1(255,102,102)+"▔▔▔                     ▔▔▔  "+s9);
        p("");
        p(s12logo+"       ▂▂▂       ▂▂▂        ");
        p(s12logo+"      ▟"+s01logo+"            ▟ "+s9+s11logo+"▙"+s9);
        p(s12logo+"     "+s02logo+" "+s01logo+"            ▟"+s0(0,0,0)+" "+s02logo+" "+s01logo+"   "+s02logo+" "+s9+s12logo+"▙"+s9);
        p(s12logo+"    ▟"+s01logo+"▔▔          ▔▔▔  "+s02logo+"    "+s9);
        p(s12logo+"  ▟"+s01logo+"                 "+s02logo+">    "+s9+s12logo+"▛"+s9);
        p(s12logo+"▟"+s01logo+"             "+s02logo+"          "+s9+s12logo+"▛"+s9);
        p(s12logo+"▜"+s01logo+"           "+s02logo+"   "+s022logo+"     "+s02logo+"  "+s9+s12logo+"▛"+s9);
        p(s12logo+"  ▜"+s01logo+"      "+s02logo+"    "+s022logo+"   "+s011logo+"  "+s02logo+"  "+s9+s12logo+"▛"+s9);
        p(s11logo+s1(255,255,255)+"    \uD83D\uDE7D \uD83D\uDE7D   "+s022logo+"   "+s011logo+"  "+s02logo+"  "+s9+s12logo+"▛"+s9);
        p(s11logo+"           "+s022logo+" "+s011logo+"   "+s02logo+"  "+s9+s12logo+"▛"+s9);
        p(s11logo+"        "+s12logo+"▟"+s011logo+"    "+s02logo+"  "+s9+s12logo+"▛"+s9);
        p(s11logo+"       "+s02logo+"       "+s9+s12logo+"▛"+s9);
    }
}
// https://www.x-ray.world/