package com.example.demo.service;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Repository.CurrencyRepository;
import com.example.demo.model.Coindesk;
import com.example.demo.model.CoindeskResp;
import com.example.demo.model.Currency;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CurrencyService   {

    @Autowired
    private CurrencyRepository currencyRepository;

    /**
     * 呼叫Ccoindesk API並取得其json資料
     * @return
     */
	public String getCoindeskAPIdata() {
		RestTemplate restTemplate = new RestTemplate();

		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
	    mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(
	    		new MediaType("application", "javascript")));
	    restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		ResponseEntity<String> rs = restTemplate.getForEntity("https://api.coindesk.com/v1/bpi/currentprice.json",
				String.class);

		return rs.getBody();
	}
    
	/**
	 * 將Ccoindesk API取得之json資料進行轉換
	 * @return
	 */
	public ResponseEntity<String> formatCoindeskAPIdata(ResponseEntity<String> resp) {
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString=StringUtils.EMPTY;
		CoindeskResp respEntity = new CoindeskResp();
		Coindesk products;
		try {

			products = mapper.readValue(resp.getBody(), new TypeReference<Coindesk>() {
			});
			List<String> codeList = new ArrayList<String>();
			codeList.add(products.getBpi().getEur().getCode());
			codeList.add(products.getBpi().getGbp().getCode());
			codeList.add(products.getBpi().getUsd().getCode());
			List<Currency> resultList = getByCodeList(codeList);
			Map<String,String> map = new HashMap<String,String>();
			resultList.forEach(item ->{
				map.put(StringUtils.upperCase(item.getCode()) , item.getName());
			});
			
			List<Currency> currencylist = new ArrayList<Currency>();
			Currency eur = new Currency();
			Currency gbp = new Currency();
			Currency usd = new Currency();
			eur.setCode(products.getBpi().getEur().getCode());
			eur.setName(map.get(products.getBpi().getEur().getCode()));
			eur.setRate(products.getBpi().getEur().getRateFloat());
			
			gbp.setCode(products.getBpi().getGbp().getCode());
			gbp.setName(map.get(products.getBpi().getGbp().getCode()));
			gbp.setRate(products.getBpi().getGbp().getRateFloat());
			
			usd.setCode(products.getBpi().getUsd().getCode());
			usd.setName(map.get(products.getBpi().getUsd().getCode()));
			usd.setRate(products.getBpi().getUsd().getRateFloat());
			currencylist.add(eur);
			currencylist.add(gbp);
			currencylist.add(usd);
			respEntity.setCurrencyList(currencylist);
			
			respEntity.setUpdated(formatDate(products.getTime().getUpdatedISO()));
			jsonString =  mapper.writeValueAsString(respEntity);
		      
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).body(jsonString);
	}
	
	public String formatDate(String dateStr) {
		OffsetDateTime odt = OffsetDateTime.parse(dateStr);
	   return odt.toLocalDateTime().format( DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss"));
	
	}
	
    public Currency insert(Currency entity) {
    	if(currencyRepository.existsByCode(entity.getCode())) {
    		return null;
    	}
        return currencyRepository.save(entity);
    }

    public Currency update(Integer id,Currency entity) {
    	if(currencyRepository.existsById(id)) {
    		entity.setId(id);
    		return currencyRepository.save(entity);
    	}
    	return null;
    }

    
    public void deleteById(Integer id) {
         currencyRepository.deleteById(id);
    }

    
    public Currency getById(Integer id) {
        return currencyRepository.findById(id).orElse(null);
    }

	
	public List<Currency> getByCodeList(List<String> codeList) {

		return currencyRepository.findByCodeIn(codeList);
	}
}
