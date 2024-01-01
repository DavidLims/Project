package com.example.project.table

class Lowongan (
    var id_lowongan: String? = null,
    var posisiLow: String? = null,
    var durasiLow: String? = null,
    var syaratLow: String? = null,
    var lowImage: String? = null,
    var namaInstansi: String? = null,
    var jumlahLow: String? = null,
    var statusLow: String? = null,
    var imageUrl: String?
)
{
    constructor(): this("", "","", "","", "", "", "", "")
}
