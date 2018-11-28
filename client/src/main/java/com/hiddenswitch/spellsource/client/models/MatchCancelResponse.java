/*
 * Hidden Switch Spellsource API
 * The Spellsource API for matchmaking, user accounts, collections management and more.  To get started, create a user account and make sure to include the entirety of the returned login token as the X-Auth-Token header. You can reuse this token, or login for a new one.  ClientToServerMessage and ServerToClientMessage are used for the realtime game state and actions two-way websocket interface for actually playing a game. Envelope is used for the realtime API services. 
 *
 * OpenAPI spec version: 2.1.0
 * Contact: ben@hiddenswitch.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.hiddenswitch.spellsource.client.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * MatchCancelResponse
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class MatchCancelResponse implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("isCanceled")
  private Boolean isCanceled = null;

  public MatchCancelResponse isCanceled(Boolean isCanceled) {
    this.isCanceled = isCanceled;
    return this;
  }

   /**
   * Get isCanceled
   * @return isCanceled
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsCanceled() {
    return isCanceled;
  }

  public void setIsCanceled(Boolean isCanceled) {
    this.isCanceled = isCanceled;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MatchCancelResponse matchCancelResponse = (MatchCancelResponse) o;
    return Objects.equals(this.isCanceled, matchCancelResponse.isCanceled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isCanceled);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MatchCancelResponse {\n");
    
    sb.append("    isCanceled: ").append(toIndentedString(isCanceled)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

