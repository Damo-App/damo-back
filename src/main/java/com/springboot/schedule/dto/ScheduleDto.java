package com.springboot.schedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.member.dto.MemberDto;
import com.springboot.schedule.entity.Schedule;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ScheduleDto {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Post {
        @NotBlank
        @Schema(description = "일정 이름", example = "오케스트라 감상")
        private String scheduleName;

        @Schema(description = "일정 소개글", example = "25일 오케스트라 감상 모임 일정이 있겠습니다.")
        private String scheduleContent;

        @NotNull
        @Schema(description = "당일 일정", example = "SINGLE")
        private Schedule.ScheduleStatus scheduleStatus; // SINGLE, CONTINUOUS, RECURRING

        @NotNull
        @Schema(description = "시작 시간", example = "2025-04-15T10:00:00", type = "string")
        private LocalDateTime startSchedule;

        @NotNull
        @Schema(description = "종료 시간", example = "2025-05-10T10:00:00", type = "string")
        private LocalDateTime endSchedule;

        // 정기 일정일 경우만 사용
        @Schema(description = "정기모임 요일(정기모임 아닐 시 안써도됨)", example = "[\"MONDAY\", \"WEDNESDAY\", \"FRIDAY\"]")
        private List<DayOfWeek> daysOfWeek;

        @Schema(description = "장소", example = "경기도 광주시 경안로 106")
        private String address;

        @Schema(description = "상세주소", example = "해태그린아파트 102동 1107호")
        private String subAddress;

        @Schema(description = "모집인원", example = "10")
        @Min(1)
        private int maxMemberCount;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Patch {
        @Schema(hidden = true)
        private Long scheduleId;

        @Schema(description = "일정 이름", example = "스케줄명")
        private String scheduleName;

        @Schema(description = "일정 소개글", example = "스케줄 소개")
        private String scheduleContent;

        @Schema(description = "시작 시간", example = "2025-04-15T10:00:00", type = "string")
        private LocalDateTime startSchedule;

        @Schema(description = "종료 시간", example = "2025-05-10T10:00:00", type = "string")
        private LocalDateTime endSchedule;

        @Schema(description = "주소", example = "서울시 강남구 중앙학원")
        private String address;

        @Schema(description = "상세 주소", example = "101동 101호")
        private String subAddress;

        @Min(1)
        @Schema(description = "모집 인원", example = "30")
        private Integer maxMemberCount;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ResponseBasic implements ScheduleResponse {
        @Schema(description = "일정 ID", example = "1")
        private Long groupScheduleId;

        @Schema(description = "모임 아이디", example = "1")
        private Long groupId;

        @Schema(description = "모임 이름", example = "고양이 모임")
        private String groupName;

        @Schema(description = "일정 이름", example = "강남역 스터디 모임")
        private String scheduleName;

        @Schema(description = "일정 소개글", example = "스터디 카페에서 스프링 강의 복습 모임입니다.")
        private String scheduleContent;

        @Schema(description = "일정 시작 날짜", example = "2025-04-01")
        private LocalDate startSchedule;

        @Schema(description = "일정 시작 시간", example = "14:00:00")
        private LocalTime startTime;

        @Schema(description = "일정 종료 날짜", example = "2025-04-01")
        private LocalDate endSchedule;

        @Schema(description = "일정 종료 시간", example = "16:00:00")
        private LocalTime endTime;

        @Schema(description = "장소 주소", example = "서울특별시 강남구 테헤란로 123")
        private String address;

        @Schema(description = "상세 주소", example = "2층 스터디룸 A")
        private String subAddress;

        @Schema(description = "최대 참여 인원", example = "10")
        private int maxMemberCount;

        @Schema(description = "현재 참여 인원 수", example = "6")
        private int memberCount;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ScheduleOfGroupResponse {
        @Schema(description = "일정 ID", example = "1")
        private long scheduleId;
        @Schema(description = "일정 이름", example = "스케줄명")
        private String scheduleName;

        @Schema(description = "일정 시작 기간", example = "2025.03.24")
        private LocalDate startDate;
        @Schema(description = "일정 시작 시간", example = "12:00")
        private LocalTime startTime;
        @Schema(description = "일정 끝 기간", example = "2025.03.29")
        private LocalDate endDate;
        @Schema(description = "일정 끝 시간", example = "16:00")
        private LocalTime endTime;

        @Schema(description = "주소", example = "서울시 강남구 중앙학원")
        private String address;
        @Schema(description = "상세 주소", example = "101동 101호")
        private String subAddress;
      
        @Schema(description = "일정 설정 상태", example = "단기 일정")
        private Schedule.ScheduleStatus scheduleStatus;
        @Schema(description = "일정 상태", example = "등록중")
        private Schedule.ScheduleState state;
        @Schema(description = "모임 멤버 목록",
                example = "[{\"memberId\": 1, \"name\": \"홍길동\", \"Image\": \"https://example.com/profiles/alice.jpg\"}, " +
                        "{\"memberId\": 2, \"name\": \"김철수\", \"Image\": \"https://example.com/profiles/bob.jpg\"}]")
        private List<MemberDto.MemberOfGroupResponse> members;
    }
  
    // 🎯 정기 일정 응답 DTO
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ResponseRecurring implements ScheduleResponse {
        @Schema(description = "일정 ID", example = "1")
        private Long groupScheduleId;

        @Schema(description = "일정 이름", example = "정기 운동 모임")
        private String scheduleName;

        @Schema(description = "일정 소개글", example = "매주 월수금 헬스장에서 운동하는 모임입니다.")
        private String scheduleContent;

        @Schema(description = "일정 시작 시간", example = "12:00")
        private LocalTime startTime;

        @Schema(description = "일정 끝 시간", example = "16:00")
        private LocalTime endTime;

        @Schema(description = "일정 시작 날짜", example = "2025-04-01")
        private LocalDate startSchedule;

        @Schema(description = "일정 종료 날짜", example = "2025-05-01")
        private LocalDate endSchedule;

        @Schema(description = "정기 요일", example = "[\"MONDAY\", \"WEDNESDAY\", \"FRIDAY\"]")
        private List<DayOfWeek> daysOfWeek;

        @Schema(description = "실제 반복되는 날짜 리스트 (날짜 + 시간 정보 포함)")
        private List<RecurringDateDto> recurringDates;

        @Schema(description = "주소", example = "서울시 강남구 논현로 100")
        private String address;

        @Schema(description = "상세 주소", example = "2층 GX룸")
        private String subAddress;

        @Schema(description = "최대 참여 인원", example = "20")
        private int maxMemberCount;

        @Schema(description = "현재 참여 인원", example = "15")
        private int memberCount;
    }

    // ✅ 반복 일정 날짜 + 시간 DTO
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class RecurringDateDto {
        @Schema(description = "일정 ID", example = "1")
        private Long groupScheduleId;

        @Schema(description = "정기 일정 날짜", example = "2025-04-03")
        private LocalDate date;

//        @Schema(description = "정기 일정 시간", example = "10:00:00")
//        private LocalTime time;

        @Schema(description = "일정 시작 시간", example = "12:00")
        private LocalTime startTime;

        @Schema(description = "일정 끝 시간", example = "16:00")
        private LocalTime endTime;
    }

    //회원의 카테고리별 일정(참여중) 조회시 -> 달력에 뿌려야하므로 기간 + 상태
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CalendarResponse {
        @Schema(description = "모임 아이디", example = "1")
        private Long groupId;
        @Schema(description = "모임 이름", example = "고양이 모임")
        private String groupName;
        @Schema(description = "일정 ID", example = "1")
        private Long groupScheduleId;
        @Schema(description = "일정 시작 기간", example = "2025.04.04")
        private LocalDate startSchedule;
        @Schema(description = "일정 끝 기간", example = "2025.04.14")
        private LocalDate endSchedule;
        //등록, 종료상태가아닌 (정기, 단기, 연속)
        @Schema(description = "일정 종류 상태", example = "RECURRING")
        private Schedule.ScheduleStatus scheduleStatus;

        // 정기 일정(RECURRING)일 경우만 값이 들어감
        private List<DayOfWeek> daysOfWeek;
    }
}


