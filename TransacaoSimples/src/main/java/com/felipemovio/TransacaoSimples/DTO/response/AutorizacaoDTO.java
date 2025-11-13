package com.felipemovio.TransacaoSimples.DTO.response;

import com.felipemovio.TransacaoSimples.DTO.request.DataDTO;

public record AutorizacaoDTO(String status, DataDTO data) {
}
