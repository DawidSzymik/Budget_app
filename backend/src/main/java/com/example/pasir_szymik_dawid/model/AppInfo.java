package com.example.pasir_szymik_dawid.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppInfo {
    public String appName;
    public String appVersion;
    public String message;
}

