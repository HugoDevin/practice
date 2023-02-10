package com.example.demo.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	/**
	 * 1. 測試呼叫查詢幣別對應表資料 API，並顯示其內容。 。
	 * @throws Exception
	 */
	@Test
	public void getById() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/currency/{id}", 0);

		mockMvc.perform(requestBuilder)
				.andDo(print())
				.andExpect(status().is(HttpStatus.OK.value()))
				.andReturn();

	}

	/**
	 *  2. 測試呼叫新增幣別對應表資料 API。
	 * @throws Exception
	 */
	@Test
	public void create() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/currency")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "	\"code\": \"SGD\",\r\n"
						+ "	\"name\": \"新加坡元\",\r\n"
						+ "	\"symbol\": \"$\"\r\n"
						+ "}");

		 mockMvc.perform(requestBuilder)
				.andExpect(status().is(HttpStatus.CREATED.value()))
				.andReturn();

	}
	/**
	 * 3. 測試呼叫更新幣別對應表資料 API，並顯示其內容。
	 * @param args
	 */
	@Test
	public void update() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/currency/{id}", 0)
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "	\"name\": \"西班牙\",\r\n"
						+ "	\"symbol\": \"€\"\r\n"
						+ "}");

		mockMvc.perform(requestBuilder)
				.andDo(print())
				.andExpect(status().is(HttpStatus.OK.value()))
				.andReturn();
		
		// 呼叫抓取data api驗證是否更新成功
		RequestBuilder requestBuilderForGet = MockMvcRequestBuilders
				.get("/currency/{id}", 0);//

		mockMvc.perform(requestBuilderForGet)
				.andDo(print())
				.andExpect(status().is(HttpStatus.OK.value()))
				.andExpect(jsonPath("$.id", equalTo(0)))
				.andExpect(jsonPath("$.name", equalTo("西班牙")))
				.andReturn();
	}
	
	/**
	 * 4. 測試呼叫刪除幣別對應表資料 API。
	 * @param args
	 */
	@Test
	public void delete() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.delete("/currency/{id}", 1)//
				.contentType(MediaType.APPLICATION_JSON);
				
		mockMvc.perform(requestBuilder)
				.andExpect(status().is(HttpStatus.NO_CONTENT.value()))//
				.andReturn();
		
		
	}
	
	/**
	 * 5. 測試呼叫 coindesk API，並顯示其內容。
	 * @param args
	 */
	@Test
	public void callCoindeskAPI() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/coindeskAPI")
				.contentType(MediaType.APPLICATION_JSON);
				
		mockMvc.perform(requestBuilder)
				.andDo(print())
				.andExpect(status().is(HttpStatus.OK.value()))
				.andReturn();
	}
	
	/**
	 * 6. 測試呼叫資料轉換的 API，並顯示其內容
	 * @param args
	 */
	@Test
	public void callCoindeskAPIAndFormat() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/coindeskAPI/format")
				.contentType(MediaType.APPLICATION_JSON);
				
		mockMvc.perform(requestBuilder)
				.andDo(print())
				.andExpect(status().is(HttpStatus.OK.value()))
				.andReturn();
	}
}
