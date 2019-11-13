package com.example.demo.Utils;
import	java.util.HashMap;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.Properties;
@Component
public class SysUtil {

    public Object getSysInfo() {
        try {
            HashMap<String, Object> mapResult = new HashMap<> ();
            Runtime r = Runtime.getRuntime();
            Properties props = System.getProperties();
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            String ip = addr.getHostAddress();
           // Map<String, String> map = System.getenv();
            //本地ip地址
            mapResult.put("ip",ip);
            //本地主机名
            mapResult.put("hostName", addr.getHostName());
            //JVM可以使用的总内存百分比
            mapResult.put("totalMemory", r.freeMemory()+"/"+r.totalMemory());
            //操作系统的名称
            mapResult.put("osName", props.getProperty("os.name"));
            //操作系統的架構
            mapResult.put("osArch", props.getProperty("os.arch"));
            //操作系统的版本
            mapResult.put("osVersion ", props.getProperty("os.version"));
           // mapResult.put("other",map);
            return mapResult;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        SysUtil sysUtil = new SysUtil();
        System.out.println(sysUtil.getSysInfo());
    }
    /**
     * 获取客户端的 IP
     * @param request
     * @return 客户端的 IP
     */
    public static String getClientIp(HttpServletRequest request) {
        final String UNKNOWN = "unknown";
        // 需要注意有多个 Proxy 的情况: X-Forwarded-For: client, proxy1, proxy2
        // 没有最近的 Proxy 的 IP, 只有 1 个 Proxy 时是客户端的 IP
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr(); // 没有使用 Proxy 时是客户端的 IP, 使用 Proxy 时是最近的 Proxy 的 IP
        }
        return ip;
    }
}
