def call(message) {
    withCredentials([
        string(credentialsId: 'telegramBotToken', variable: 'TOKEN'),
        string(credentialsId: 'telegramChatId', variable: 'CHAT_ID')
    ]) {
        sh """
        curl -G 'https://api.telegram.org/bot$TOKEN/sendMessage' \
            --data-urlencode "chat_id=$CHAT_ID" \
            --data-urlencode "text=$message"
        """
    }  
}