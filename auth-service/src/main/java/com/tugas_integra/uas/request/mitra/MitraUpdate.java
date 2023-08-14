package com.tugas_integra.uas.request.mitra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MitraUpdate {
    private Long Id;
    private String name;
    private String mitraName;
    private String email;
    private String address;
    private Long phoneNumber;
}
