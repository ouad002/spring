package com.emse.spring.automacorp;

import java.util.List;

public interface WindowDaoCustom {
      List<WindowEntity> findRoomsWithOpenWindows(Long id);
}
