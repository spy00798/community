package com.board.community.common.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CommonService {

    public String MapToJson(Map<String, Object> map) {
        String json = "";
        try {
            ObjectMapper mapper = new ObjectMapper(); // 자바 객체를 String으로 변환하거나 String을 자바 객체로 변환

            json = mapper.writeValueAsString(map); // 파라미터로 전송받은 맵을 String으로 변환

        } catch (JsonProcessingException e) { // 호환되지 않는 데이터 형식 발견 시 예외처리
            e.printStackTrace();

        }
        return json;

    }
}
