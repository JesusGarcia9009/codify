import React from 'react';
import { useForm } from "react-hook-form";

import 'bootstrap/dist/css/bootstrap.min.css';

import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

import Image from 'react-bootstrap/Image'

import './App.css';

function App() {

  const { register, handleSubmit, watch, errors } = useForm();
  const onSubmit = data => console.log(data);

  console.log(watch("username", "password")); // watch input value by passing the name of it

  return (
    <Container fluid>
      <Row>
        <Col className="left-Column" />
        <Col className="login-form">
          <Form onSubmit={handleSubmit(onSubmit)}>

            <Image src="indice.jpg" className="pl-4 pb-3" />  
            
            <h5 className="text-center pr-3">Te damos la bienvenida!</h5>
            <p className="text-center pr-3 pl-3 pb-3">Ingresa tus datos para acceder a tu cuenta</p>
            
            <Form.Group controlId="formBasicEmail" className="pt-3">
              <Form.Label>Ingresa tu correo electrónico</Form.Label>
              <Form.Control type="email" placeholder="Ingresa tu correo electrónico"
                name="username" ref={register({ required: true })} />
            </Form.Group>

            <Form.Group controlId="formBasicPassword" className="p-0">
              <Form.Label>Ingresa tu contraseña</Form.Label>
              <Form.Control type="password" placeholder="Ingresa tu contraseña"
                name="password" ref={register({ required: true })} />
            </Form.Group>
            <Form.Group controlId="formBasicCheckbox" className="pb-5">
              <Form.Check type="checkbox" label="Recordar mi sesión" />
            </Form.Group>

            {errors.password && <span>This field is required</span>}
            
            <div className="pb-2">
              <Button className="btn-block" variant="outline-primary" type="submit">
                Registrarme
              </Button>
              <Button className="btn-block" variant="outline-primary" type="submit">
                Acceder
              </Button>
            </div>
                        
            <div className="text-center pt-5">
              <a href="/forgot-password">¿Olvidó su contraseña?</a>
            </div>
          </Form>
        </Col>
      </Row>
    </Container>
  );
}

export default App;
