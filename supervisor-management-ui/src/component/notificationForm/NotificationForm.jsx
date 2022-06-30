import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import { toast, ToastContainer } from "react-toastify";
import { Form, FormGroup, Label, Input, Card, CardBody, CardHeader, Col, Button } from 'reactstrap'
import { getAppSupervisors, sentNotification } from "../../api/supervisorAPI";

const notificationDetails = {
    supervisor: 0,
    phoneNumber: "",
    email: "",
    firstName: "",
    lastName: ""

}

const emailOrPhone = {
    isEmail: false,
    isPhone: false
}

const NotificationForm = () => {

    const [supervisor, setSupervisor] = useState([]);
    const [notificationRequest, setNotificationRequest] = useState(notificationDetails);
    const [emailOrPhoneData, setEmailOrPhoneData] = useState(emailOrPhone)

    const getAppSupervisorsDetails = () => {
        getAppSupervisors().then((res) => {

            if (res && res.status === "OK") {
                toast.success(res.message);
                setSupervisor(res.data)
            } else {
                toast.error(res.message)
            }

        }).catch((err) => toast.error(err))
    }

    useEffect(() => {getAppSupervisorsDetails()}, [])



    const validEmail = (email) => {
        let pattern = /^$|^.*@.*\..*$/;
        return pattern.test(email);
    }

    const validPhoneNumber = (phoneNumber) => {
        let pattern = /^$|[0-9]{10}/;
        return pattern.test(phoneNumber);
    }

    const submitData = (e) => {
        if (notificationRequest.firstName.trim() === '') {
            toast.error("firstName must be required!!")
            return false;
        }

        if (notificationRequest.lastName.trim() === '') {
            toast.error("lastName must be required!!")
            return false;
        }

        if (notificationRequest.supervisor === '' || notificationRequest.supervisor === 0 || notificationRequest.supervisor === '0') {
            toast.error("supervisor must be required!!")
            return false;
        }

        if (!validEmail(notificationRequest.email)) {
            toast.error("please add valid email id!!")
            return false
        }

        if (!validPhoneNumber(notificationRequest.phoneNumber)) {
            toast.error("please add valid phone numberid!!")
            return false
        }


        sentNotification(notificationRequest).then((res) => {
            if (res && res.status === "OK") {
                toast.success(res.message);
                setNotificationRequest(notificationDetails);
                setEmailOrPhoneData(emailOrPhone);
            } else {
                let msg = res.message;
                const list = msg.slice(1, -1).split(",")
                list.forEach((data) => {
                    toast.error(data.split("=")[1])
                })
            }
        }).catch((e) => {
            console.log("err", e)
            toast.error(e.message)
        })

    }

    return <div className="notification_class">
        <Card className="w-50">
            <CardHeader className="text-center header_class">Notification Form</CardHeader>
            <CardBody className="body_class">

                <Form className="row" method="post">
                    <Col xl={6} md={6} sm={12}>
                        <FormGroup>
                            <Label for="firstName">First Name</Label>
                            <Input type="text" name="firstName" value={notificationRequest.firstName} id="firstName"
                                onChange={(e) => setNotificationRequest({
                                    ...notificationRequest,
                                    firstName: e.target.value
                                })}
                            />
                        </FormGroup>
                    </Col>
                    <Col xl={6} md={6} sm={12}>
                        <FormGroup>
                            <Label for="lastName">Last Name</Label>
                            <Input type="text" name="lastName" id="lastName" value={notificationRequest.lastName}
                                onChange={(e) => setNotificationRequest({
                                    ...notificationRequest,
                                    lastName: e.target.value
                                })}
                            />
                        </FormGroup>
                    </Col>
                    <Col xl={12} md={12} sm={12} ><Label disabled>How would you prefer to be notified?</Label></Col>
                    <Col xl={6} md={6} sm={12}>
                        <FormGroup>
                            <Input type="checkbox" checked={emailOrPhoneData.isEmail}
                                onChange={(e) => setEmailOrPhoneData({
                                    ...emailOrPhoneData,
                                    isEmail: !emailOrPhoneData.isEmail
                                })
                                }
                            />{' '}<Label for="email">Email</Label>
                            <Input type="email" name="email" id="email" value={notificationRequest.email}
                                disabled={!emailOrPhoneData.isEmail}
                                onChange={(e) => setNotificationRequest({
                                    ...notificationRequest,
                                    email: e.target.value
                                })}
                            />
                        </FormGroup>
                    </Col>
                    <Col xl={6} md={6} sm={12}>
                        <FormGroup>
                            <Input type="checkbox" checked={emailOrPhoneData.isPhone}
                                onChange={
                                    (e) => setEmailOrPhoneData({
                                        ...emailOrPhoneData,
                                        isPhone: !emailOrPhoneData.isPhone
                                    })
                                }
                            />{' '}<Label for="phoneNumber">Phone Number</Label>
                            <Input type="text" name="phoneNumber" id="phoneNumber" value={notificationRequest.phoneNumber}
                                disabled={!emailOrPhoneData.isPhone}
                                onChange={(e) => setNotificationRequest({
                                    ...notificationRequest,
                                    phoneNumber: e.target.value
                                })}
                            />
                        </FormGroup>
                    </Col>
                    <Col xl={3} md={3} sm={12} />
                    <Col xl={6} md={6} sm={12}>
                        <FormGroup>
                            <Label for="supervisor">Supervisor</Label>
                            <Input type="select" value={notificationRequest.supervisor} name="supervisor" id="supervisor"
                                onChange={(e) => setNotificationRequest({
                                    ...notificationRequest,
                                    supervisor: e.target.value
                                })}
                            >
                                <option value={0} >Select...</option>
                                {supervisor && supervisor.map((data, index) => {
                                    return <option key={index} value={data}>{data}</option>
                                })}
                            </Input>
                        </FormGroup>
                    </Col>
                    <Col xl={3} md={3} sm={12} />
                    <Col xl={12} md={12} sm={12} className="text-center">
                        <Button className="btn-primary submit_button" onClick={(e) => submitData(e)}>Submit</Button>
                    </Col>
                </Form>

            </CardBody>
        </Card>
        <ToastContainer
            position="top-right"
            autoClose={5000}
            hideProgressBar={false}
            newestOnTop={false}
            closeOnClick
            rtl={false}
            pauseOnFocusLoss
            draggable
            pauseOnHover
        />
    </div>
}

export default NotificationForm;