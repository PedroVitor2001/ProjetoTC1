import { Heading, Box, FormControl, FormLabel, Input, Button } from "@chakra-ui/react";
import { useState, useEffect } from "react";
import React from "react";
import Nav from "../components/Nav";
import Footer from "../components/Footer";
export default function () {
  const [data, setData] = useState([]);
  const [title, setTitle] = useState("");
  const [gender, setGender] = useState("");

  useEffect(() => {
    const storedData = localStorage.getItem("card_Books");
    if (storedData) {
      setData(JSON.parse(storedData));
    }
  }, []);

  const handleSaveClick = () => {
    if (!title || !gender) {
      window.alert("All fields are required");
      return;
    }
    const newDataArray = [...data, { title, gender }];
    setData(newDataArray);
    try {
      localStorage.setItem("card_Books", JSON.stringify(newDataArray));
      window.alert("Cadastrado com sucesso");
    } catch (error) {
      window.alert("Cadastro n realizado");
    }
  };

  return (
    <Box
      alignSelf="center"
      justifySelf="center"
      width={{ base: "100%", md: "50vw", lg: "50vw" }}
      minH={"80vh"}
      display="flex"
      alignItems="center"
      flexDir="column"
      gap="5vh"
      m={"auto"}
      maxW={"1920px"}
    >
      <Nav />
      <Box
        gap={"5vh"}
        w="80%"
        alignContent="center"
        border="1px solid black"
        p={4}
        mt={"auto"}
        mb="auto"
        display={"flex"}
        flexDir={"column"}
        justifyItems={"center"}
        justifySelf={"center"}
      >
        <Box display="flex" justifyContent="center" w={"100%"}>
          <Heading display="flex" mt="10px" justifySelf="center" textAlign={"center"}>
            Lista de Leituras
          </Heading>
        </Box>

        <FormControl display="flex" flexDir="column" gap={4}>
          <Box>
            <FormLabel>Título:</FormLabel>
            <Input type="text" value={title} onChange={(e) => setTitle(e.target.value)} />
          </Box>
          <Box>
            <FormLabel>Gênero:</FormLabel>
            <Input type="text" value={gender} onChange={(e) => setGender(e.target.value)} />
          </Box>
        </FormControl>

        <Box display="flex" justifyContent="center" w={"100%"}>
          <Button colorScheme="green" onClick={handleSaveClick}>
            Cadastrar
          </Button>
        </Box>
      </Box>
      <Footer />
    </Box>
  );
}
