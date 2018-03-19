/*
 * Hidden Switch Spellsource API
 * The Spellsource API for matchmaking, user accounts, collections management and more
 *
 * OpenAPI spec version: 1.0.1
 * Contact: benjamin.s.berman@gmail.com
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
import com.hiddenswitch.spellsource.client.models.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * GameEventPerformedGameAction
 */

public class GameEventPerformedGameAction implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("source")
  private Entity source = null;

  @JsonProperty("target")
  private Entity target = null;

  @JsonProperty("description")
  private String description = null;

  public GameEventPerformedGameAction source(Entity source) {
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @ApiModelProperty(value = "")
  public Entity getSource() {
    return source;
  }

  public void setSource(Entity source) {
    this.source = source;
  }

  public GameEventPerformedGameAction target(Entity target) {
    this.target = target;
    return this;
  }

   /**
   * Get target
   * @return target
  **/
  @ApiModelProperty(value = "")
  public Entity getTarget() {
    return target;
  }

  public void setTarget(Entity target) {
    this.target = target;
  }

  public GameEventPerformedGameAction description(String description) {
    this.description = description;
    return this;
  }

   /**
   * A plain-text description of the game action that should be rendered on the client. 
   * @return description
  **/
  @ApiModelProperty(value = "A plain-text description of the game action that should be rendered on the client. ")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameEventPerformedGameAction gameEventPerformedGameAction = (GameEventPerformedGameAction) o;
    return Objects.equals(this.source, gameEventPerformedGameAction.source) &&
        Objects.equals(this.target, gameEventPerformedGameAction.target) &&
        Objects.equals(this.description, gameEventPerformedGameAction.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(source, target, description);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GameEventPerformedGameAction {\n");
    
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

