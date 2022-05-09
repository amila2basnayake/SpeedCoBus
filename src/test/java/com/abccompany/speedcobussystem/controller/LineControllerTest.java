package com.abccompany.speedcobussystem.controller;

import com.abccompany.speedcobussystem.model.Line;
import com.abccompany.speedcobussystem.model.dto.LineDto;
import com.abccompany.speedcobussystem.service.LineService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class LineControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private LineService lineService;

    private static final String URL_TEMPLATE = "/line";
    private Line line = null;
    private LineDto lineDto = null;

    @BeforeEach
    void setUp() {
        lineDto = new LineDto(1L,"AX12");

        line = new Line(1L,"AX12");


    }

    @Nested
    @DisplayName("Add Line")
    class AddLine {

        @Test
        @DisplayName("should return a valid status")
        public void post_line_should_return_a_valid_status() throws Exception {

            Mockito.doReturn(line).when(lineService).createLine(line);

            mockMvc.perform(post(URL_TEMPLATE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(lineDto)))
                    .andDo(print())
                    .andExpect(status().isCreated())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.name", is(line.getName())));
        }


        @Test
        @DisplayName("should return a error code")
        public void post_line_should_return_a_error_code() throws Exception {
            LineDto nullNameLineDto = new LineDto(1L,null);
            Mockito.doReturn(line).when(lineService).createLine(line);

            mockMvc.perform(post(URL_TEMPLATE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(nullNameLineDto)))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());

        }
    }


    @Nested
    @DisplayName("Get Line")
    class GetLine {
        @Test
        @DisplayName("should return a valid status")
        public void get_line_should_return_a_valid_status() throws Exception {
            List<Line>  lineList = new ArrayList<>();
            lineList.add(line);

            Mockito.doReturn(lineList).when(lineService).searchLineByNameAndId(line);
            mockMvc.perform(get("/line/search")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(lineDto)))
                    .andDo(print())
                    .andExpect(status().isOk());
        }


    }


    @Nested
    @DisplayName("Remove Line")
    class RemoveLine {

    }
}
