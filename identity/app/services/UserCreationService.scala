package services

import com.google.inject.Singleton
import com.gu.identity.model.{StatusFields, PublicFields, PrivateFields, User}

@Singleton
class UserCreationService {

    def createUser(firstName: String, secondName: String, email: String, userName: String,  password: String,
                     gnmMarketing: Boolean, thirdPartyMarketing: Boolean, registrationIp: Option[String]): User = {
      val user = User(
        primaryEmailAddress = email,
        password = Some(password),
        publicFields = PublicFields(username = Some(userName)),
        privateFields = PrivateFields(firstName = Some(firstName), secondName = Some(secondName), registrationIp = registrationIp)
      )
        user.getStatusFields().setReceiveGnmMarketing(gnmMarketing)
        user.getStatusFields().setReceive3rdPartyMarketing(thirdPartyMarketing)
      user
    }
}
