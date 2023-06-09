package com.smu.smuenip.enums.message;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.smu.smuenip.enums.message.meesagesDetail.MessagesFail;
import com.smu.smuenip.enums.message.meesagesDetail.MessagesSuccess;
import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = MessagesSuccess.class, name = "success"),
    @JsonSubTypes.Type(value = MessagesFail.class, name = "fail")
})
public interface Messages extends Serializable {

    public String getMessage();

}
