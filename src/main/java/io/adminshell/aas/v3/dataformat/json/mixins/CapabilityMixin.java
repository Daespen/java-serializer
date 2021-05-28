package io.adminshell.aas.v3.dataformat.json.mixins;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Capability")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "modelType")
public interface CapabilityMixin {

}