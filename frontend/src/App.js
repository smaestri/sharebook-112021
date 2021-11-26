import React, { useEffect } from 'react'
import ListBooks from './ListBooks'
import MyBooks from './MyBooks'
import AddBook from './AddBook'
import AddUser from './AddUser'
import MyBorrows from './MyBorrows'
import Header from './Header'
import Login from './Login'
import { BrowserRouter, Route, useHistory } from 'react-router-dom'

import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios'

const UserConnected = ({ setUserInfo, userInfo }) => {
  const history = useHistory();
  useEffect(() => {
    axios.get('/isConnected').then(response => {
      if (history.location.pathname === "/") {
        history.push("/listBooks")
      }
      else {
        history.push(history.location.pathname)
      }

      setUserInfo(response.data)
    }, () => {
      console.error('user unknown')
      history.push("/login")
      setUserInfo(null)

    })
  }, [history, setUserInfo]);

  return (<>
    {userInfo && <Header userInfo={userInfo} setUserInfo={setUserInfo} />}
  </>
  )
}


function App() {

  const [userInfo, setUserInfo] = React.useState('');

  return (
    <div>

      <BrowserRouter>
        <div className="container">
          <UserConnected userInfo={userInfo} setUserInfo={setUserInfo} />
          <Route path="/listBooks">
            <ListBooks />
          </Route>
          <Route path="/myBooks">
            <MyBooks />
          </Route>
          <Route exact path="/addBook">
            <AddBook />
          </Route>
          <Route exact path="/addBook/:bookId">
            <AddBook />
          </Route>
          <Route path="/myBorrows">
            <MyBorrows />
          </Route>
          <Route path="/login">
            <Login setUserInfo={setUserInfo} />
          </Route>
          <Route path="/addUser">
            <AddUser setUserInfo={setUserInfo} />
          </Route>

        </div>
      </BrowserRouter>
    </div>
  );
}

export default App;