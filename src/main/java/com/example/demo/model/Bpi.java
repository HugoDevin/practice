
package com.example.demo.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "USD",
    "GBP",
    "EUR"
})
@Generated("jsonschema2pojo")
public class Bpi {

    @JsonProperty("USD")
    private Usd usd;
    @JsonProperty("GBP")
    private Gbp gbp;
    @JsonProperty("EUR")
    private Eur eur;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("USD")
    public Usd getUsd() {
        return usd;
    }

    @JsonProperty("USD")
    public void setUsd(Usd usd) {
        this.usd = usd;
    }

    @JsonProperty("GBP")
    public Gbp getGbp() {
        return gbp;
    }

    @JsonProperty("GBP")
    public void setGbp(Gbp gbp) {
        this.gbp = gbp;
    }

    @JsonProperty("EUR")
    public Eur getEur() {
        return eur;
    }

    @JsonProperty("EUR")
    public void setEur(Eur eur) {
        this.eur = eur;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Bpi.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("usd");
        sb.append('=');
        sb.append(((this.usd == null)?"<null>":this.usd));
        sb.append(',');
        sb.append("gbp");
        sb.append('=');
        sb.append(((this.gbp == null)?"<null>":this.gbp));
        sb.append(',');
        sb.append("eur");
        sb.append('=');
        sb.append(((this.eur == null)?"<null>":this.eur));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
