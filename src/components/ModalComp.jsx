import {
  Modal,
  ModalOverlay,
  ModalContent,
  ModalHeader,
  ModalFooter,
  ModalBody,
  ModalCloseButton,
  Button,
  FormControl,
  FormLabel,
  Input,
  Box,
} from "@chakra-ui/react";
import { useState } from "react";

const ModalComp = ({ data, setData, dataEdit, isOpen, onClose }) => {
  const [title, settitle] = useState(dataEdit.title || "");
  const [gender, setgender] = useState(dataEdit.gender || "");

  const handleSave = () => {
    if (Object.keys(dataEdit).length) {
      data[dataEdit.index] = { title, gender };
    }

    const newDataArray = !Object.keys(dataEdit).length
      ? [...(data ? data : []), { title, gender }]
      : [...(data ? data : [])];

    localStorage.setItem("card_Books", JSON.stringify(newDataArray));

    setData(newDataArray);

    onClose();
  };

  return (
    <>
      <Modal isOpen={isOpen} onClose={onClose}>
        <ModalOverlay />
        <ModalContent>
          <ModalHeader>Editar Livros</ModalHeader>
          <ModalCloseButton />
          <ModalBody>
            <FormControl display="flex" flexDir="column" gap={4}>
              <Box>
                <FormLabel>Titulo</FormLabel>
                <Input type="text" value={title} onChange={(e) => settitle(e.target.value)} />
              </Box>
              <Box>
                <FormLabel>Gênero</FormLabel>
                <Input type="text" value={gender} onChange={(e) => setgender(e.target.value)} />
              </Box>
            </FormControl>
          </ModalBody>

          <ModalFooter justifyContent="start">
            <Button colorScheme="green" mr={3} onClick={handleSave}>
              SALVAR
            </Button>
            <Button colorScheme="red" onClick={onClose}>
              CANCELAR
            </Button>
          </ModalFooter>
        </ModalContent>
      </Modal>
    </>
  );
};

export default ModalComp;
