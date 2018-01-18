package com.journaler.api.service.reactor

import com.journaler.api.mail.MailMessage
import com.journaler.api.mail.MailService
import com.journaler.api.reactor.NotesCountNotification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NotesCountNotificationServiceImpl : NotesCountNotificationService {

    @Autowired
    private lateinit var mailService: MailService

    override fun notify(notification: NotesCountNotification) {
        val to = "your_email@example.com"
        val subject = "Notes count notification"
        val text = "Notes reached ${notification.notesCount} count."
        val message = MailMessage(to, subject, text)
        mailService.sendMessage(message)
    }

}