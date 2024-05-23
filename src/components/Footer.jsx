import { Box, Text } from "@chakra-ui/react";
import React from "react";

const Footer = () => {
  return (
    <Box
      as="footer"
      width="100%"
      py={4}
      backgroundColor="gray.100"
      color="black"
      textAlign="center"
      position="fixed"
      bottom={0}
    >
      <Text>Feito com ❤️ por João C. Lucas S. Erick G.</Text>
    </Box>
  );
};

export default Footer;
