package com.example.demo.Service;

import com.example.demo.Utils.Result;
import org.springframework.stereotype.Service;

@Service
public interface SystemService {
    Result getSystem();

    Result getDatabaseInfo();

    Result getUplockPassword();
}
