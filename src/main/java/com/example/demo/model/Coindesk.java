
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
    "time",
    "disclaimer",
    "chartName",
    "bpi"
})
@Generated("jsonschema2pojo")
public class Coindesk {

    @JsonProperty("time")
    private Time time;
    @JsonProperty("disclaimer")
    private String disclaimer;
    @JsonProperty("chartName")
    private String chartName;
    @JsonProperty("bpi")
    private Bpi bpi;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("time")
    public Time getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Time time) {
        this.time = time;
    }

    @JsonProperty("disclaimer")
    public String getDisclaimer() {
        return disclaimer;
    }

    @JsonProperty("disclaimer")
    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    @JsonProperty("chartName")
    public String getChartName() {
        return chartName;
    }

    @JsonProperty("chartName")
    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    @JsonProperty("bpi")
    public Bpi getBpi() {
        return bpi;
    }

    @JsonProperty("bpi")
    public void setBpi(Bpi bpi) {
        this.bpi = bpi;
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
        sb.append(Coindesk.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("time");
        sb.append('=');
        sb.append(((this.time == null)?"<null>":this.time));
        sb.append(',');
        sb.append("disclaimer");
        sb.append('=');
        sb.append(((this.disclaimer == null)?"<null>":this.disclaimer));
        sb.append(',');
        sb.append("chartName");
        sb.append('=');
        sb.append(((this.chartName == null)?"<null>":this.chartName));
        sb.append(',');
        sb.append("bpi");
        sb.append('=');
        sb.append(((this.bpi == null)?"<null>":this.bpi));
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
