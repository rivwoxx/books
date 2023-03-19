package com.rivwoxx.books.utils;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.SneakyThrows;
import java.util.Objects;

public final class Utils {

  private Utils() {}

  private static ObjectMapper mapper;

  @SneakyThrows
  public static String toJsonFormat(final Object obj) {
    if (Objects.isNull(mapper)) {
      mapper = new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
      mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }
    return mapper.writeValueAsString(obj);
  }
}
