package com.cnxs.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateToStringSerializer extends JsonSerializer<Date>{
    
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException, JsonProcessingException {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        gen.writeObject(formatter.format(value));
        
    }

}
