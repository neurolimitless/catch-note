package com.hido.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomDateDeserealizer extends JsonDeserializer<java.util.Date> {

  private SimpleDateFormat dateFormat = new SimpleDateFormat(
      "yyyy-MM-dd HH:mm:ss");

  @Override
  public java.util.Date deserialize(JsonParser paramJsonParser,
                                    DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException {
    String str = paramJsonParser.getText().trim();
    try {
      return dateFormat.parse(str);
    } catch (ParseException e) {

    }
    return paramDeserializationContext.parseDate(str);
  }
}