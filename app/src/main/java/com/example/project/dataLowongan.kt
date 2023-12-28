package com.example.project

class dataLowongan {
    var id_lowongan: String? = null
    var dataPosisi: String? = null
    var dataDurasi: String? = null
    var dataSyarat: String? = null
    var dataImage: String? = null

    constructor(id_lowongan: String?, dataPosisi: String?, dataDurasi: String?, dataSyarat: String?, dataImage: String?){
        this.id_lowongan = id_lowongan
        this.dataPosisi = dataPosisi
        this.dataDurasi = dataDurasi
        this.dataSyarat = dataSyarat
        this.dataImage = dataImage
    }
}