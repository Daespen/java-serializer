package io.adminshell.aas.v3.dataformat.json.mixins.custom;

import com.fasterxml.jackson.annotation.JsonInclude;

public interface FileMixin {

    @JsonInclude(JsonInclude.Include.ALWAYS)
    public String getMimeType();
}
