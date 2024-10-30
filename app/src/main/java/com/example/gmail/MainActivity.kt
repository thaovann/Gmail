package com.example.gmail

import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var emailListLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailListLayout = findViewById(R.id.email_list)

        // Sample email data
        val emails = listOf(
            Email("Edurila.com", "New features are available!", "10:30 AM"),
            Email("Chris Abad", "Let's connect over coffee.", "11:15 AM"),
            Email("Tuto.com", "Check out our latest tutorials.", "Yesterday"),
            Email("Support", "Need assistance? We are here to help.", "12:30 PM"),
            Email("Matt from Ionic", "Exciting updates from Ionic.", "1:45 PM"),
            Email("Edurila.com", "New features are available!", "10:30 AM"),
            Email("Chris Abad", "Let's connect over coffee.", "11:15 AM"),
            Email("Tuto.com", "Check out our latest tutorials.", "Yesterday"),
            Email("Support", "Need assistance? We are here to help.", "12:30 PM"),
            Email("Matt from Ionic", "Exciting updates from Ionic.", "1:45 PM"),
            Email("Edurila.com", "New features are available!", "10:30 AM"),
            Email("Chris Abad", "Let's connect over coffee.", "11:15 AM"),
            Email("Tuto.com", "Check out our latest tutorials.", "Yesterday"),
            Email("Support", "Need assistance? We are here to help.", "12:30 PM"),
            Email("Matt from Ionic", "Exciting updates from Ionic.", "1:45 PM"),
            Email("Edurila.com", "New features are available!", "10:30 AM"),
            Email("Chris Abad", "Let's connect over coffee.", "11:15 AM"),
            Email("Tuto.com", "Check out our latest tutorials.", "Yesterday"),
            Email("Support", "Need assistance? We are here to help.", "12:30 PM"),
            Email("Matt from Ionic", "Exciting updates from Ionic.", "1:45 PM")
            // Add more emails as needed
        )

        // Add emails to layout
        for (email in emails) {
            val emailItemView = createEmailItemView(email)
            emailListLayout.addView(emailItemView)
        }
    }

    private fun createEmailItemView(email: Email): LinearLayout {
        val inflater = layoutInflater
        val view = inflater.inflate(R.layout.email_item, null) as LinearLayout

        // Set subject, content, and time
        val subjectTextView: TextView = view.findViewById(R.id.email_subject)
        val contentTextView: TextView = view.findViewById(R.id.email_content)
        val timeTextView: TextView = view.findViewById(R.id.email_time)
        val starButton: ImageButton = view.findViewById(R.id.email_star)

        subjectTextView.text = email.subject
        contentTextView.text = email.content
        timeTextView.text = email.time

        // Toggle favorite status
        var isFavorite = false
        starButton.setOnClickListener {
            isFavorite = !isFavorite
            starButton.setImageResource(
                if (isFavorite) R.drawable.icons8_star_filled_50 else R.drawable.icons8_star_50
            )
        }

        return view
    }
}

