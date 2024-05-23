import { EditIcon, DeleteIcon } from "@chakra-ui/icons";
import { Box, Flex, useDisclosure, Table, Thead, Tr, Th, Tbody, Td, useBreakpointValue } from "@chakra-ui/react";
import { useEffect, useState } from "react";
import ModalComp from "../components/ModalComp";
import Nav from "../components/Nav";
import Footer from "../components/Footer";

export default function List() {
  const { isOpen, onOpen, onClose } = useDisclosure();
  const [data, setData] = useState([]);
  const [dataEdit, setDataEdit] = useState({});

  const isMobile = useBreakpointValue({
    base: true,
    lg: false,
  });

  useEffect(() => {
    const db_costumer = localStorage.getItem("card_Books") ? JSON.parse(localStorage.getItem("card_Books")) : [];
    setData(db_costumer);
  }, [setData]);

  const handleRemove = (gender) => {
    const newArray = data.filter((item) => item.gender !== gender);
    setData(newArray);
    localStorage.setItem("card_Books", JSON.stringify(newArray));
  };

  return (
    <Flex h="100vh" align="center" justify="center" fontFamily="poppins" flexDir={"column"}>
      <Nav />
      <Box maxW={800} w="100%" h="100vh" py={10} px={2}>
        <Box height="fit-content" mt={"auto"} border="1px solid black" borderRadius={8}>
          <Table mt="6">
            <Thead>
              <Tr>
                <Th maxW={isMobile ? 5 : 100} fontSize="18px">
                  Nome
                </Th>
                <Th maxW={isMobile ? 5 : 100} fontSize="18px">
                  Gênero
                </Th>
                <Th p={0}></Th>
                <Th p={0}></Th>
              </Tr>
            </Thead>
            <Tbody>
              {data.map(({ title, gender }, index) => (
                <Tr key={index} cursor="pointer " _hover={{ bg: "gray.100" }}>
                  <Td maxW={isMobile ? 5 : 100}>{title}</Td>
                  <Td maxW={isMobile ? 5 : 100}>{gender}</Td>
                  <Td p={0}>
                    <EditIcon fontSize={20} onClick={() => [setDataEdit({ title, gender, index }), onOpen()]} />
                  </Td>
                  <Td p={0}>
                    <DeleteIcon fontSize={20} onClick={() => handleRemove(gender)} />
                  </Td>
                </Tr>
              ))}
            </Tbody>
          </Table>
        </Box>
      </Box>
      {isOpen && (
        <ModalComp
          isOpen={isOpen}
          onClose={onClose}
          data={data}
          setData={setData}
          dataEdit={dataEdit}
          setDataEdit={setDataEdit}
        />
      )}
      <Footer />
    </Flex>
  );
}
