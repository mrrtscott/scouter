package com.capstone2021.scouter.controller

import com.capstone2021.scouter.service.DocumentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.util.*


@RestController
@RequestMapping("/document")
class DocumentController {

    @Autowired
    lateinit var documentService: DocumentService

    @PostMapping("/upload-files/{applicantId}/{applicationId}")
    fun uploadFiles(@PathVariable("applicantId") applicantId: Long, @PathVariable("applicationId") applicationId: Long,
        @RequestParam("files") files: List<MultipartFile?>?,
        redirectAttributes: RedirectAttributes
    ){

        if (files != null) {
            for (file in files){
                if (file != null) {
                    documentService.addDocument(applicantId, applicationId, file)
                }
            }

            }
        }
    }

