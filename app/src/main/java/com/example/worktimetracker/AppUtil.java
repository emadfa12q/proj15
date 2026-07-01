package com.example.worktimetracker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import java.security.MessageDigest;
import java.util.Locale;

final class AppUtil {
    private static final String[] PAL={"#3b82f6","#f97316","#a855f7","#22c55e","#eab308","#06b6d4","#ef4444","#14b8a6","#8b5cf6","#f59e0b"};
    private AppUtil(){}

    static String appLabel(Context c,String pkg){
        String friendly = friendlyName(pkg);
        if (friendly != null) return friendly;
        try{
            PackageManager pm=c.getPackageManager();
            ApplicationInfo ai=pm.getApplicationInfo(pkg,0);
            CharSequence l=pm.getApplicationLabel(ai);
            String label=l==null?"":l.toString().trim();
            if(label.isEmpty() || label.equals(pkg) || label.toLowerCase(Locale.US).contains("launcher") || label.toLowerCase(Locale.US).contains("main")){
                String f=friendlyName(pkg);
                return f==null?(pkg==null?"Unknown":pkg):f;
            }
            return label;
        }catch(Exception e){return pkg==null?"Unknown":(friendly==null?pkg:friendly);} 
    }

    static String friendlyName(String pkg){
        if(pkg==null)return null;
        String p=pkg.toLowerCase(Locale.US);
        if(p.equals("ir.eitaa.messenger")||p.contains("eitaa"))return "Eitaa";
        if(p.contains("telegram"))return "Telegram";
        if(p.contains("whatsapp"))return "WhatsApp";
        if(p.contains("instagram"))return "Instagram";
        if(p.contains("youtube"))return "YouTube";
        if(p.contains("chrome"))return "Chrome";
        if(p.contains("firefox"))return "Firefox";
        if(p.contains("edge"))return "Microsoft Edge";
        if(p.contains("gmail"))return "Gmail";
        if(p.contains("google.android.apps.docs"))return "Google Drive";
        if(p.contains("google.android.apps.photos"))return "Google Photos";
        if(p.contains("google.android.apps.maps"))return "Google Maps";
        if(p.contains("bale"))return "Bale";
        if(p.contains("rubika"))return "Rubika";
        if(p.contains("aparat"))return "Aparat";
        if(p.contains("spotify"))return "Spotify";
        if(p.contains("calculator"))return "Calculator";
        if(p.contains("settings"))return "Settings";
        return null;
    }

    static String categoryFor(String app,String pkg){String a=((app==null?"":app)+" "+(pkg==null?"":pkg)).toLowerCase(Locale.US);if(a.contains("chrome")||a.contains("browser")||a.contains("firefox")||a.contains("edge"))return"Web";if(a.contains("telegram")||a.contains("whatsapp")||a.contains("messenger")||a.contains("eitaa")||a.contains("bale")||a.contains("rubika"))return"Chat";if(a.contains("youtube")||a.contains("video")||a.contains("music")||a.contains("aparat")||a.contains("spotify"))return"Media";if(a.contains("office")||a.contains("pdf")||a.contains("docs"))return"Documents";return"Other";}
    static String colorFor(String app){String k=app==null?"unknown":app.toLowerCase(Locale.US);try{byte[]d= MessageDigest.getInstance("MD5").digest(k.getBytes("UTF-8"));int v=Math.abs(((d[0]&255)<<24)|((d[1]&255)<<16)|((d[2]&255)<<8)|(d[3]&255));return PAL[v%PAL.length];}catch(Exception e){return PAL[Math.abs(k.hashCode())%PAL.length];}}
    static int parseColor(String c,int f){try{return Color.parseColor(c);}catch(Exception e){return f;}}
}
