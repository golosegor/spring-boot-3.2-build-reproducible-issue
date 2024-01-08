package com.se.shared.libraries;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DateUtilTest {
  @Test
  void dateIsNotNull() {
    assertThat(new DateUtil().getDate()).isNotNull();
  }
}
