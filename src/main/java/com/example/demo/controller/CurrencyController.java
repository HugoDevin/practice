package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Currency;
import com.example.demo.service.CurrencyService;

@RestController
public class CurrencyController {

	@Autowired
	private CurrencyService currencyService;

	/**
	 *  幣別 DB 維護功能 - 新增。<br>
	 * 成功:HttpStatus 201<br>
	 * 失敗:HttpStatus 202<br>
	 * @param currency
	 * @return
	 */
	@PostMapping("/currency")
	public ResponseEntity<?> create(@RequestBody Currency currency) {

		return ResponseEntity.status(currencyService.insert(currency)!=null
				?HttpStatus.CREATED:HttpStatus.ACCEPTED).build();
	}

	/**
	 * 幣別 DB 維護功能 - 更新。<br>
	 * 成功:HttpStatus 200<br>
	 * 失敗:HttpStatus 202<br>
	 * @param id
	 * @param currency
	 * @return
	 */
	@PutMapping("/currency/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Currency currency) {

		return ResponseEntity.status(currencyService.update(id,currency)!=null
				?HttpStatus.OK:HttpStatus.ACCEPTED).build();
	}

	/**
	 * 幣別 DB 維護功能 - 刪除。<br>
	 * 成功:HttpStatus 204<br>
	 * 失敗:HttpStatus 202<br>
	 * @param id
	 * @return
	 */
	@DeleteMapping("/currency/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		currencyService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	/**
	 * 幣別 DB 維護功能 - 單筆查詢。<br>
	 * 成功:HttpStatus 200<br>
	 * @param id
	 * @return
	 */
	@GetMapping("/currency/{id}")
	public ResponseEntity<Currency> read(@PathVariable Integer id) {
		Currency currency = currencyService.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(currency);
	}
	
	/**
	 * 呼叫 coindesk 的 API。
	 * 成功:HttpStatus 200<br>
	 * @return
	 */
	@GetMapping("/coindeskAPI")
	public ResponseEntity<String> coindeskAPI() {
		String jsonData = currencyService.getCoindeskAPIdata();

		return ResponseEntity.status(HttpStatus.OK).body(jsonData);
	}
	
	/**
	 * 呼叫 coindesk 的 API，並進行資料轉換，組成新 API。<br>
	 * 	此新 API 提供：<br>
	 * 	A. 更新時間（時間格式範例：1990/01/01 00:00:00）。<br>
 	 * 	B. 幣別相關資訊（幣別，幣別中文名稱，以及匯率）。<br>
	 * 成功:HttpStatus 200<br>
	 * @return
	 */
	@GetMapping("/coindeskAPI/format")
	public ResponseEntity<String> getCoindeskAPIdataAndFormat() {
		ResponseEntity<String> coindeskAPIResp = coindeskAPI();
		
		ResponseEntity<String> formatResp = currencyService.formatCoindeskAPIdata(coindeskAPIResp);
		
		return ResponseEntity.status(HttpStatus.OK).body(formatResp.getBody());
	}
}