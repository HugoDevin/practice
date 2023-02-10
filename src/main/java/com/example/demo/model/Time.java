
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
    "updated",
    "updatedISO",
    "updateduk"
})
@Generated("jsonschema2pojo")
public class Time {

    @JsonProperty("updated")
    private String updated;
    @JsonProperty("updatedISO")
    private String updatedISO;
    @JsonProperty("updateduk")
    private String updateduk;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("updated")
    public String getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @JsonProperty("updatedISO")
    public String getUpdatedISO() {
        return updatedISO;
    }

    @JsonProperty("updatedISO")
    public void setUpdatedISO(String updatedISO) {
        this.updatedISO = updatedISO;
    }

    @JsonProperty("updateduk")
    public String getUpdateduk() {
        return updateduk;
    }

    @JsonProperty("updateduk")
    public void setUpdateduk(String updateduk) {
        this.updateduk = updateduk;
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
        sb.append(Time.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("updated");
        sb.append('=');
        sb.append(((this.updated == null)?"<null>":this.updated));
        sb.append(',');
        sb.append("updatedISO");
        sb.append('=');
        sb.append(((this.updatedISO == null)?"<null>":this.updatedISO));
        sb.append(',');
        sb.append("updateduk");
        sb.append('=');
        sb.append(((this.updateduk == null)?"<null>":this.updateduk));
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
